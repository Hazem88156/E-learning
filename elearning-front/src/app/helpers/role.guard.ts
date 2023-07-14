import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let helper = new JwtHelperService();
    let token = localStorage.getItem('token');
    let decoded = helper.decodeToken('token');
    if (token == null) {
      this.router.navigate(['login']);
      return false;
    }

    if (decoded.roles == next.data.role) {
      return true;
    } else if (decoded.roles == 'ASSISTANT') {
      this.router.navigate(['dashboard']);
      return false;
    } else if (decoded.roles == 'AGENT') {
      this.router.navigate(['listtickets']);
      return false;
    } else {
      this.router.navigate(['dashboard']);
      return false;
    }
  }
}
