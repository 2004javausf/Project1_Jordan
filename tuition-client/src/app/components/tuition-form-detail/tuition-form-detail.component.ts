import { Component, OnInit, Input } from '@angular/core';
import { TuitionForm } from 'src/app/interfaces/tuition-form';
import { FormService } from 'src/app/services/form.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/interfaces/employee';
import { User } from 'src/app/interfaces/user';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-tuition-form-detail',
  templateUrl: './tuition-form-detail.component.html',
  styleUrls: ['./tuition-form-detail.component.css']
})
export class TuitionFormDetailComponent implements OnInit {

  myTuitionForm: FormGroup

  loading = false;
  success = false;

  @Input() form: TuitionForm;
  @Input() employee: Employee;

  user: User = {
    user_id: 0,
    name: "",
    password: ""
  }

  constructor(
    private fb: FormBuilder,
    private formService: FormService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.getUserForm();
    // this.myTuitionForm = this.fb.group({
    //   first_name: this.form.first_name,
    //   last_name: this.form.last_name,
    //   start_date: this.form.start_date,
    //   start_time: this.form.start_time,
    //   location: this.form.location,
    //   descritption: this.form.description,
    //   cost: this.form.cost,
    //   event_type: this.form.event_type,
    //   user_id: this.form.user_id,
    //   grade_id: this.form.grade_id
    // })

    this.myTuitionForm = this.fb.group({
      form_id: '',
      first_name: '',
      last_name: '',
      start_date: '',
      start_time: '',
      location: '',
      description: '',
      cost: 0,
      event_type: '',
      user_id: 0,
      grade_id: 0
    })
  }

  getUserForm(): void {
    this.user.user_id = +this.route.snapshot.paramMap.get('id');
    this.formService.getFormById(this.user).subscribe((res) =>{
      this.editForm(res);
    });
  }

  async onSubmit(){
    this.loading = true;
    const formValue = this.myTuitionForm.value;
    console.log(formValue);
    this.formService.updateForm(formValue).subscribe((res)=>{
      console.log(res);
    })
  }

  editForm(form: TuitionForm){
    this.myTuitionForm.patchValue({
      form_id: form.form_id,
      first_name: form.first_name,
      last_name: form.last_name,
      start_date: form.start_date,
      start_time: form.start_time,
      location: form.location,
      description: form.description,
      cost: form.cost,
      event_type: form.event_type,
      user_id: form.user_id,
      grade_id: form.grade_id
    })
  }

  

}
