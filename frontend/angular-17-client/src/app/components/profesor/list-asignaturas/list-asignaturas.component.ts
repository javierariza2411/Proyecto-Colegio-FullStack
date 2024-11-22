import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Asignatura } from '../../../models/asignatura.model';

@Component({
  selector: 'app-list-asignaturas',
  templateUrl: './list-asignaturas.component.html',
  styleUrl: './list-asignaturas.component.css'
})
export class ListAsignaturasComponent {

  asignaturas:Asignatura[]=[];
  currentAsignatura: Asignatura = {};
  currentIndex = -1;
  

  @Input() set getAsignaturas(asignaturas:Asignatura[]){
    this.asignaturas=asignaturas;
  } 


  @Input() showActivate: boolean=false;


  @Output() selectAsignatura: EventEmitter<Asignatura> = new EventEmitter();


  seleccionarAsignatura(asignatura: Asignatura,index: number) {
    this.currentAsignatura = asignatura;
    this.currentIndex = index;
    this.selectAsignatura.emit(asignatura);
  }


}
