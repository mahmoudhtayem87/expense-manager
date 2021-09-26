import { Injectable } from "@angular/core";
import {ActivatedRoute, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree} from "@angular/router";
import { Observable } from "rxjs";
import { tap, map } from "rxjs/operators";
declare const Liferay: any;
@Injectable()
export class guardService {
    constructor(
        private route: ActivatedRoute,
        private router: Router) { }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):  Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree  {
        if (!Liferay.ThemeDisplay.isSignedIn()) {
            this.router.navigate(['/notSignedIn']); //Redirect if not authenticated
            return false;
        } else {
            return true;
        }
    }
}