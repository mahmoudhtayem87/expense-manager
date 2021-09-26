import { Component } from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

declare const Liferay: any;

@Component({
	template:`
		<router-outlet></router-outlet>`,
})
export class AppComponent {
	params: any;
	labels: any;
	constructor(private router: Router,private activeRoute:ActivatedRoute) {
		this.labels = {
			configuration: Liferay.Language.get('configuration'),
			portletNamespace: Liferay.Language.get('portlet-namespace'),
			contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}
	ngOnInit() {

		var urlPart = window.location.href;
		var navURL = '/';
		var index = urlPart.indexOf( "#" );
		if (index != -1 ) {
			navURL = urlPart.substring(index+1,urlPart.length);
		}
		this.router.navigateByUrl(navURL).then(e => {
			console.log(navURL);
		});
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}

}
