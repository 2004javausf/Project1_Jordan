import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TuitionFormDetailComponent } from './tuition-form-detail.component';

describe('TuitionFormDetailComponent', () => {
  let component: TuitionFormDetailComponent;
  let fixture: ComponentFixture<TuitionFormDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TuitionFormDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TuitionFormDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
