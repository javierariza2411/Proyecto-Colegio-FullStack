import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { AddProfesorComponent } from './components/profesor/add-profesor/add-profesor.component';
import { AddAsignaturaComponent } from './components/asignatura/add-asignatura/add-asignatura.component';
import { ProfesorComponent } from './components/profesor/profesor/profesor.component';

const routes: Routes = [
  { path: '', redirectTo: 'profesor', pathMatch: 'full' },
  { path: 'profesor', component: ProfesorComponent },
  { path: 'asignatura', component: AsignaturaComponent},
  { path: 'addprofesores', component: AddProfesorComponent },
  { path: 'addasignaturas', component: AddAsignaturaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
