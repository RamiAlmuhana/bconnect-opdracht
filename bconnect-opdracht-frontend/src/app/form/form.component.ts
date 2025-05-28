import { Component } from '@angular/core';
import {FormControl, FormGroup, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';

import { CompanyService } from '../service/company.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent {
  employeeOptions = ['1-10', '11-20', '21-50', '51-300', '300+'];

  companyForm: FormGroup;

  errorMessage = '';

  constructor(
    private fb: NonNullableFormBuilder,
    private companyService: CompanyService
  ) {
    this.companyForm = this.fb.group({
      companyName: ['', Validators.required],
      telephoneNumber: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      employees: ['', Validators.required],
      coCNumber: ['', [Validators.required, Validators.pattern('^[0-9]{8,12}$')]],
      vatNumber: ['', [Validators.required, Validators.pattern('^[0-9]{9}B0[0-9]{1,2}$')]],
      ibanNumber: ['', [Validators.required, Validators.pattern('^NL\\d{2}[A-Z]{4}\\d{10}$')]],
      budget: [0],
      description: ['', [Validators.required, Validators.maxLength(1000)]]
    });
  }

  onSubmit() {
    if (this.companyForm.invalid) {
      this.companyForm.markAllAsTouched();
      return;
    }

    console.log(this.companyForm.value);

    this.companyService.createCompany(this.companyForm.value)
      .subscribe({
        next: () => {
          this.companyForm.reset();
          this.errorMessage = '';
        },
        error: () => {
          this.errorMessage = 'Iets misgegaan probeer het opnieuw.';
        }
      });
  }
}
