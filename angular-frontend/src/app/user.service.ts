import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUsersList(): Observable<any> {
    return this.http.get(environment.apiUrl);
  }

  registerUser(user: Object): Observable<Object> {
    return this.http.post(environment.apiUrl, user);
  }

}
