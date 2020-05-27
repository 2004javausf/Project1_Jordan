import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../interfaces/employee';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpService: HttpClient) { }

  getEmployee(user: User): Observable<Employee>{

    return this.httpService.post<any>('http://localhost:8080/TuitionReimbursement/employee/login', JSON.stringify(user))
  }
}
