import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Payment} from '../entity/payment';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private API = 'http://localhost:8080/api';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    'Access-Control-Allow-Origin': 'http://localhost:4200',
    'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  };

  constructor(private http: HttpClient) {
  }

  savePayment(payment: Payment): Observable<Payment> {
    return this.http.post<Payment>(this.API + '/payment', payment, this.httpOptions);
  }

  findById(id: number): Observable<Payment> {
    return this.http.get<Payment>(this.API + '/payment/' + id, this.httpOptions);
  }

}
