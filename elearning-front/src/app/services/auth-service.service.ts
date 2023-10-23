import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BehaviorSubject, forkJoin, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../Models/users';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  apiUrl = environment.apiUrl;
  private user = new User();
  isLoggedIn = false;
  choixmenu: string = 'A';
  redirectUrl!: string;
  private currentUserSubject!: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  public formData!: FormGroup;
  host: string = 'http://localhost:8081';
  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(
      JSON.parse(localStorage.getItem('currentUser') || '{}')
    );
    this.currentUser = this.currentUserSubject.asObservable();
  }
  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }
  login(email: string, password: string) {
    return this.http
      .post<any>(`${this.apiUrl}/auth/login`, { email, password })
      .pipe(
        map((user) => {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          return user;
        })
      );
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next({} as User);
  }
  public postRequestsFromMultipleSources(
    data: any,
    firstpath: any,
    secondpath: any
  ): Observable<any[]> {
    let response1 = this.http.post<any>(this.apiUrl + '/auth' + firstpath, data);
    console.log(response1);
    return forkJoin([response1]);
  }

  register(user: User): Observable<any> {
    return this.http
      .post<any>(`${this.apiUrl}/auth/register`, user)
      .pipe(
        map((user) => {
          this.currentUserSubject.next(user);
          return user;
        })
      );
  }

  private log(message: string) {
    console.log(message);
  }

  createUser(formData: FormData): Observable<any> {
    return this.http.post<any>(
      `${this.apiUrl}/auth/users`,
      formData
    );
  }
  updateUser(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/auth/updateEtudiant/${id}`,
      formData
    );
  }
  updateEtudiant(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/auth/updateEtudiant/${id}`,
      formData
    );
  }
  getData(id: number): Observable<Object> {
    return this.http.get(`${this.apiUrl}/auth/users/${id}`);
  }
  updatedata(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.apiUrl}/auth/users/${id}`, value);
  }
  getUsers(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/auth/users`);
  }
  getUserRoles(roles: string): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/auth/usersss/` + roles
    );
  }
  getUserStatusRoles(status: string, roles: string): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/auth/userstatusroles/` + status + `/` + roles
    );
  }
  getUserById(id: number): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/auth/userdetail/`+ id
    );
  }
  setter(user: User) {
    this.user = user;
  }
  getter() {
    return this.user;
  }
  active(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/auth/userstatus/${id}`,
      formData
    );
  }

  deleteUser(id: number) {
    return this.http.delete(`${this.apiUrl}/auth/deleteuser/${id}`);
  }
}
