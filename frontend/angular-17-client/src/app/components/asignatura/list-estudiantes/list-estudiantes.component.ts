import { Component, Input } from '@angular/core';
import { Estudiante } from '../../../models/estudiante.model';

@Component({
  selector: 'app-list-estudiantes',
  templateUrl: './list-estudiantes.component.html',
  styleUrl: './list-estudiantes.component.css'
})
export class ListEstudiantesComponent {

  estudiantes: Estudiante[]=[]; 

@Input() set getEstudiantes(estudiantes: Estudiante[]){

  this.estudiantes=estudiantes;
} 

}
