import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Employee } from './interfaces/employee';
import { User } from './interfaces/user';
import { EmployeeService } from './services/employee.service';
import { Supervisor } from './interfaces/supervisor';
import { BenCo } from './interfaces/benefits';
import { SupervisorService } from './services/supervisor.service';
import { BenefitsService } from './services/benefits.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tuition-client';

  myLogin: FormGroup;

  loading = false;
  success = false;
  isLoggedIn = false;
  status = '';

  employee: Employee = {
    employee_id: 0,
    first_name: "",
    last_name: "",
    tuition_limit: 0,
    user_id: 0,
    dept_id: 0

  }

  supervisor: Supervisor =  {
    supervisor_id: 0,
    first_name: '',
    last_name: '',
    tuition_limit: 0, 
    dhead: 'NO',
    user_id: 0,
    dept_id: 0
  }

  benco: BenCo = {
    benco_id: 0,
    first_name: '',
    last_name: '',
    tuition_limit: 0,
    dhead: 'NO',
    user_id: 0,
    dept_id: 0
  }

  user: User = {
    user_id: 0,
    name: "",
    password: ""
  }



  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private supervisorService: SupervisorService,
    private benfitsService: BenefitsService
  ) { }

  ngOnInit(): void {
    this.myLogin = this.fb.group({
      name: '',
      password: ''
    })

   // this.myLogin.valueChanges.subscribe(console.log);
  }


  logOut(){
    this.isLoggedIn = false;
    //Resets All Entities
    this.employee = {
      employee_id: 0,
      first_name: "",
      last_name: "",
      tuition_limit: 0,
      user_id: 0,
      dept_id: 0
    }

    this.benco = {
      benco_id: 0,
      first_name: '',
      last_name: '',
      tuition_limit: 0,
      dhead: 'NO',
      user_id: 0,
      dept_id: 0
    }

    this.employee = {
      employee_id: 0,
      first_name: "",
      last_name: "",
      tuition_limit: 0,
      user_id: 0,
      dept_id: 0

    }


    this.status = '';
  }

  async employeeLogin(){
    this.status = 'employee'
    this.loading = true;
    const formValue = this.myLogin.value;
    this.employeeService.getEmployee(formValue).subscribe((res) => {
      this.employee = res;
      this.isLoggedIn = true;
      console.log(this.status)
      console.log(this.employee);
    });
  }

  async supervisorLogin() {
    this.status = 'supervisor'
    this.loading = true;
    const formValue = this.myLogin.value;
    this.supervisorService.getSupervisor(formValue).subscribe((res) => {
      this.supervisor = res;
      this.isLoggedIn = true;
      console.log(this.status)
      console.log(this.supervisor);
    });
  }

   async benefitsLogin() {
    this.status = 'benefits'
    this.loading = true;
    const formValue = this.myLogin.value;
    this.benfitsService.getBenCo(formValue).subscribe((res) => {
      this.benco = res;
      this.isLoggedIn = true;
      console.log(this.status)
      console.log(this.benco);
    });
  }


}
