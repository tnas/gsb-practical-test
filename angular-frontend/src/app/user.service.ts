import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8000/springboot-rest/api/v1/users';

  constructor(private http: HttpClient) { }

  registerUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
