import { Component, OnInit, Input } from '@angular/core';
import { FormService } from 'src/app/services/form.service';
import { TuitionForm } from 'src/app/interfaces/tuition-form';
import { BenefitsService } from 'src/app/services/benefits.service';
import { EmployeeService } from 'src/app/services/employee.service';
import { SupervisorService } from 'src/app/services/supervisor.service';
import { User } from 'src/app/interfaces/user';
import { Supervisor } from 'src/app/interfaces/supervisor';
import { BenCo } from 'src/app/interfaces/benefits';
import { Employee } from 'src/app/interfaces/employee';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-submitted-forms',
  templateUrl: './submitted-forms.component.html',
  styleUrls: ['./submitted-forms.component.css']
})
export class SubmittedFormsComponent implements OnInit {

  submittedForms: TuitionForm[];
  @Input() user_id;


  user: User = {
    user_id: 0,
    name: "",
    password: ""
  }

  supervisor: Supervisor;
  benco: BenCo;
  employee: Employee;

  status = '';


  constructor(
    private formService: FormService,
    private benefitsService: BenefitsService,
    private employeeService: EmployeeService,
    private supervisorService: SupervisorService
    ) { }

  ngOnInit(): void {
    this.getSubmittedForms();

  }


  getSubmittedForms() {
    this.formService.getSubmittedForms().subscribe(res => {
      this.submittedForms = res;
    })
  }

  approve(form: TuitionForm) {
    console.log(form);
    form.approved = "APPROVED"
    this.user.user_id = form.user_id;
    this.employeeService.getEmployeeById(this.user).subscribe(res => {
      this.employee = res;
      this.employee.tuition_limit = this.employee.tuition_limit - form.cost  
      console.log(this.employee)
      this.employeeService.updateEmployee(this.employee).subscribe(response => {
        console.log(`Updated employee tuition limit to ${this.employee.tuition_limit}`)
      });
      this.formService.updateForm(form).subscribe(res => {
        console.log(`Approval has been set`)
      });
    })
    

   }

  deny(form: TuitionForm) {
    console.log(form);
    let message = prompt("Reason for denial", "Not enough info");
    if (message== null || message == "") {
     let txt = "User cancelled the prompt.";
     alert(txt);
    } else{
    form.approved = "DENIED"
    this.formService.updateForm(form).subscribe(res => {
      console.log(`Denial has been set`)
    });
  }
  }

  getEmployeeById(user: User): any{

  }
}
