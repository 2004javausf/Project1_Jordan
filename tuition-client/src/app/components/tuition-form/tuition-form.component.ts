import { Component, OnInit, Input } from '@angular/core';
import { FormService } from '../../services/form.service';
import {TuitionForm} from '../../interfaces/tuition-form'
import {FormBuilder} from '@angular/forms';
import { Employee } from 'src/app/interfaces/employee';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-tuition-form',
  templateUrl: './tuition-form.component.html',
  styleUrls: ['./tuition-form.component.css']
})
export class TuitionFormComponent implements OnInit {

  @Input() employee: Employee;
  @Input() loggedIn;

  empId = 0;

 form: TuitionForm = {
   form_id: 0,
   first_name: "",
   last_name: "",
   start_date: "",
   start_time: "",
   location: "",
   description: "",
   cost: 0,
   event_type: "",
   user_id: 0,
   grade_id: 0,
   submitted: '',
   approved: ''

 } 
 submit = false;

  constructor(
    private formService: FormService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.empId = +this.route.snapshot.paramMap.get('id');
  }

  onSubmit(){
    this.submit = true;
    this.form.user_id = this.empId
    this.formService.addForm(this.form).subscribe(res =>{ 
      this.form.first_name= "";
      this.form.last_name= "";
      this.form.start_date= "";
      this.form.start_time= "";
      this.form.location= "";
      this.form.description= "";
      this.form.cost= 0;
      this.form.event_type= "";
      this.form.user_id =0
      this.form.grade_id= 0;
      this.form.submitted ='NO';
      this.form.approved = "PENDING"
    })
  }


}
