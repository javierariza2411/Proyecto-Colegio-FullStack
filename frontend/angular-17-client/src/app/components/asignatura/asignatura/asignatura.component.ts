import { Component, OnInit } from '@angular/core';
import { Asignatura } from '../../../models/asignatura.model';
import { AsignaturaService } from '../../../services/asignatura.service';
import { Estudiante } from '../../../models/estudiante.model';


@Component({
  selector: 'app-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrls: ['./asignatura.component.css'],
})
export class AsignaturaComponent implements OnInit {
  asignaturas: Asignatura[]=[];
  estudiantes: Estudiante[]=[];

  currentAsignatura: Asignatura = {};
  
  constructor(private asignaturaService: AsignaturaService) {}

  ngOnInit(): void {
    this.loadAsignaturas();
  }

  loadAsignaturas(): void {
    this.asignaturaService.getAll().subscribe({
      next: (data) => {
        this.asignaturas = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  
  getEstudiantesByAsignatura(event: Estudiante): void {
    this.currentAsignatura=event;
    this.asignaturaService.getEstudiantesByAsignatura(event.id).subscribe({
      next: (data) => {
        this.estudiantes = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

 
  
}
