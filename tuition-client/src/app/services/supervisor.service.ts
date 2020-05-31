import { Injectable } from '@angular/core';
import { Supervisor } from '../interfaces/supervisor';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SupervisorService {

  constructor(private httpService: HttpClient) { }

  getSupervisor(user: User): Observable<Supervisor> {

    return this.httpService.post<any>('http://localhost:8080/TuitionReimbursement/supervisor/login', JSON.stringify(user))
  }
}
