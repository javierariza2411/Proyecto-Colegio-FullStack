import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Profesor } from '../../../models/profesor.model';


@Component({
  selector: 'app-list-profesor',
  templateUrl: './list-profesor.component.html',
  styleUrls: ['./list-profesor.component.css'],
})
export class ListProfesorComponent {
  profesores?: Profesor[];

  currentProfesor: Profesor = {};
  currentIndex = -1;

  @Input() set getProfesores(profesores : Profesor[]) {
    this.profesores= profesores
  };


  @Output() selectProfesor: EventEmitter<Profesor> = new EventEmitter();


  seleccionarProfesor(profesor: Profesor,index: number) {
    this.currentProfesor = profesor;
    this.currentIndex = index;
    this.selectProfesor.emit(profesor);
  }


}
