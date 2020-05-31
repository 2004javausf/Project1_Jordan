import { Component, OnInit, Input } from '@angular/core';
import { FormService } from 'src/app/services/form.service';
import { TuitionForm } from 'src/app/interfaces/tuition-form';

@Component({
  selector: 'app-submitted-forms',
  templateUrl: './submitted-forms.component.html',
  styleUrls: ['./submitted-forms.component.css']
})
export class SubmittedFormsComponent implements OnInit {

  submittedForms: TuitionForm[];
  @Input() user_id;

  constructor(private formService: FormService) { }

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
    this.formService.updateForm(form).subscribe(res =>{
      console.log(`Approval has been set`)
    });
  }

  deny(form: TuitionForm) {
    console.log(form);
    form.approved = "DENIED"
    this.formService.updateForm(form).subscribe(res => {
      console.log(`Denial has been set`)
    });
  }
}
