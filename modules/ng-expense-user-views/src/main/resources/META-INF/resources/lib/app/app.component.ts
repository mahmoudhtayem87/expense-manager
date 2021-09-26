import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {TranslationService} from './services/translation.service';
import {ConstantsService} from "./services/constants.service";


declare const Liferay: any;

@Component({
	template:`
		<router-outlet></router-outlet>`,
})
export class AppComponent implements OnInit{
	params: any;
	labels: any;
	constructor(private router: Router,private activeRoute:ActivatedRoute,
				private _ConstantsService:ConstantsService,
				private _TranslationService:TranslationService) {
		this.labels = {
			configuration: Liferay.Language.get('configuration'),
			portletNamespace: Liferay.Language.get('portlet-namespace'),
			contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}


	ngOnInit() {
		this._TranslationService.Appinit_loadTranslations().then((result)=>{
			if(Liferay.ThemeDisplay.isSignedIn())
			this.CheckTranslations(result);
			var urlPart = window.location.href;
			var navURL = '/';
			var index = urlPart.indexOf( "#" );
			if (index != -1 ) {
				navURL = urlPart.substring(index+1,urlPart.length);
			}
			this.router.navigateByUrl(navURL).then(e => {
				this.router.navigate(['/expenselist']);
			});
		},error=>{
			var urlPart = window.location.href;
			var navURL = '/';
			var index = urlPart.indexOf( "#" );
			if (index != -1 ) {
				navURL = urlPart.substring(index+1,urlPart.length);
			}
			this.router.navigateByUrl(navURL).then(e => {
				this.router.navigate(['/expenselist']);
			});
		});

	}

	CheckTranslations(translationsObject:Array<any>)
	{
		var applicationTranslationsKeys = this._ConstantsService.TranslationArray;
		applicationTranslationsKeys.forEach(_item=>{
			var componentAvailableTranslations =
				translationsObject.filter(item=>item.componentId === _item.component);
			_item.translations.forEach(key=>{
				var item = componentAvailableTranslations.filter(translationItem=> translationItem.key === key);
				if (item === null || item.length <=0 )
				{
					console.log("Translation Key: "+ key
						+ " is not available, we will add it for you, please make sure to provide proper translation");
					this._TranslationService.addTranslationItem(key,key,_item.component);
				}
			});
		});
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}


}
