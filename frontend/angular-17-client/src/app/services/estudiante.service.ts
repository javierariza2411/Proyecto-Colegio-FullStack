import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudiante } from '../models/estudiante.model';

const baseUrl = 'http://localhost:8080/api/estudiante';

@Injectable({
  providedIn: 'root',
})
export class EstudianteService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(baseUrl);
  }

  get(id: any): Observable<Estudiante> {
    return this.http.get<Estudiante>(`${baseUrl}/${id}`);
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

  findByTitle(title: any): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(`${baseUrl}?title=${title}`);
  }
}
