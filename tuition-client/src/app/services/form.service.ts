import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {TuitionForm} from '../interfaces/tuition-form';
import {Observable} from 'rxjs';
import { User } from '../interfaces/user';


@Injectable({
  providedIn: 'root'
})
export class FormService {
  

  constructor(private httpService: HttpClient) { }

  addForm(form: TuitionForm): Observable<any>{
   return this.httpService.post<any>('http://localhost:8080/TuitionReimbursement/form', JSON.stringify(form));
  }

  updateForm(form: TuitionForm): Observable<any>{
    return this.httpService.put<any>('http://localhost:8080/TuitionReimbursement/form', JSON.stringify(form))
  }
  
  getFormById(user: User): Observable<any>{
   return this.httpService.post<any>('http://localhost:8080/TuitionReimbursement/getForm', JSON.stringify(user));
  }

  getSubmittedForms(): Observable<TuitionForm[]>{
    return this.httpService.get<TuitionForm[]>('http://localhost:8080/TuitionReimbursement/getForm');
  }
}
