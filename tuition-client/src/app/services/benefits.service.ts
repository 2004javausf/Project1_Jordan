import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BenCo } from '../interfaces/benefits';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class BenefitsService {

  constructor(private httpService: HttpClient) { }

  getBenCo(user: User): Observable<BenCo> {

    return this.httpService.post<any>('http://localhost:8080/TuitionReimbursement/benco/login', JSON.stringify(user))
  }

}
