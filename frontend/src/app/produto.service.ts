import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private baseUrl = 'http://localhost:8080/api/v1/produtos';

  constructor(private http: HttpClient) { }

  getProdutos(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  getProduto(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  createProduto(pessoa:Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, pessoa);
  }
  updateProduto(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  deleteProduto(id: number): Observable<Object> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType:'text'});
  }
}
