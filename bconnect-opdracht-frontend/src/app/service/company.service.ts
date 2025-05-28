import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Company {
  companyName: string;
  telephoneNumber: string;
  employees: string;
  coCNumber: string;
  vatNumber: string;
  ibanNumber: string;
  budget: number;
  description: string;
}

@Injectable({ providedIn: 'root' })
export class CompanyService {
  private apiUrl = 'http://localhost:8080/api/companies';

  constructor(private http: HttpClient) {}

  createCompany(data: Company): Observable<Company> {
    return this.http.post<Company>(this.apiUrl, data);
  }
}
