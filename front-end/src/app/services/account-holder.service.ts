
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080';

@Injectable({providedIn: 'root'})
export class AccountHolderService {
  constructor(private http: HttpClient) { }
  
  list(): Observable<any> {
    return this.http.get(`${baseUrl}/v1/api/account-holders`);
  }
  create(accountholders:any): Observable<any> {
    return this.http.post(`${baseUrl}/v1/api/account-holders`,accountholders);
  }
  }
