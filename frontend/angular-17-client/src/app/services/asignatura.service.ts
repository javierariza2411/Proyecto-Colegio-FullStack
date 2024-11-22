import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Asignatura } from '../models/asignatura.model';
import { Estudiante } from '../models/estudiante.model';

const baseUrl = 'http://localhost:8080/api/asignatura';

@Injectable({
  providedIn: 'root',
})
export class AsignaturaService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Asignatura[]> {
    return this.http.get<Asignatura[]>(baseUrl);
  }


  get(id: any): Observable<Asignatura> {
    return this.http.get<Asignatura>(`${baseUrl}/${id}`);
  }


  getEstudiantesByAsignatura(id:any): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(`${baseUrl}/${id}/estudiantes`);
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

  findByTitle(title: any): Observable<Asignatura[]> {
    return this.http.get<Asignatura[]>(`${baseUrl}?title=${title}`);
  }
}
