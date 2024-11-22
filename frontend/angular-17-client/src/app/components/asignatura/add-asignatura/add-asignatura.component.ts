import { Component } from '@angular/core';
import { Asignatura } from '../../../models/asignatura.model';
import { AsignaturaService } from '../../../services/asignatura.service';


@Component({
  selector: 'app-add-asignatura',
  templateUrl: './add-asignatura.component.html',
  styleUrls: ['./add-asignatura.component.css'],
})
export class AddAsignaturaComponent {
  asignatura: Asignatura = {
    nombre: ''
  };
  submitted = false;

  constructor(private asignaturaService: AsignaturaService) {}

  saveAsignatura(): void {
    const data = {
      title: this.asignatura.nombre,
    };

    this.asignaturaService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }

  newAsignatura(): void {
    this.submitted = false;
    this.asignatura = {
      nombre: ''
    };
  }
}
