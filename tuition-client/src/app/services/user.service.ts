import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(private httpService: HttpClient) { }

  getAllUsers(): Observable<User[]>{
    return this.httpService.get<User[]>("http://localhost:8080/TuitionReimbursement/users");
  }

  addUser(user: User): Observable<any>{
    return this.httpService.post<any>("http://localhost:8080/TuitionReimbursement/users", JSON.stringify(user))
  }
}
