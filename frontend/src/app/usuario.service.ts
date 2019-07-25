import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private baseUrl = 'http://localhost:8080/api/v1/usuarios';

  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  getUsuario(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  createUsuario(pessoa:Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, pessoa);
  }
  updateUsuario(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  deleteProduto(id: number): Observable<Object> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType:'text'});
  }
}
