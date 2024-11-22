import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profesor } from '../models/profesor.model';
import { Asignatura } from '../models/asignatura.model';

const baseUrl = 'http://localhost:8080/api/profesor';

@Injectable({
  providedIn: 'root',
})
export class ProfesorService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(baseUrl);
  }

  get(id: any): Observable<Profesor> {
    return this.http.get<Profesor>(`${baseUrl}/${id}`);
  }

  getAsigaturas(id: any): Observable<Asignatura[]> {
    return this.http.get<Asignatura[]>(`${baseUrl}/${id}`+'/asignaturas');
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(`${baseUrl}?title=${title}`);
  }
}
