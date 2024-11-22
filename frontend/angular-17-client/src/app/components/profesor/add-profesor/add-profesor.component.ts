import { Component } from '@angular/core';
import { Profesor } from '../../../models/profesor.model';
import { ProfesorService } from '../../../services/profesor.service';

@Component({
  selector: 'app-add-profesor',
  templateUrl: './add-profesor.component.html',
  styleUrls: ['./add-profesor.component.css'],
})
export class AddProfesorComponent {
  profesor: Profesor = {
    nombre: ''
  };
  submitted = false;

  constructor(private profesorService: ProfesorService) {}

  guardarProfesor(): void {
    const data = {
      nombre: this.profesor.nombre
    
    };

    this.profesorService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }

  newTutorial(): void {
    this.submitted = false;
    this.profesor = {
      nombre: ''
    };
  }
}
