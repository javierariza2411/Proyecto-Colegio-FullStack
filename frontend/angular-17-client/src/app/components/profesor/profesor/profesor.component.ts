import { Component, OnInit } from '@angular/core';
import { ProfesorService } from '../../../services/profesor.service';
import { Profesor } from '../../../models/profesor.model';
import { Asignatura } from '../../../models/asignatura.model';

@Component({
  selector: 'app-profesor',
  templateUrl: './profesor.component.html',
  styleUrl: './profesor.component.css'
})
export class ProfesorComponent implements OnInit{

  asignaturas: Asignatura[]=[];
  profesores: Profesor[]=[];
  currentProfesor: Profesor={};


  constructor(private profesorService: ProfesorService) {}

  ngOnInit(): void {
    this.loadProfesores();
  }

  loadProfesores(): void {
    this.profesorService.getAll().subscribe({
      next: (data) => {
        this.profesores = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  getAsignaturas(event:Profesor):void{

    this.currentProfesor=event;
    
    this.profesorService.getAsigaturas(event.id).subscribe({
      next: (data) => {
        this.asignaturas = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

}
