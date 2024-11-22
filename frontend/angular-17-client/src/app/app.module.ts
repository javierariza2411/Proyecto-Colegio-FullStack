import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddAsignaturaComponent } from './components/asignatura/add-asignatura/add-asignatura.component';
import { AddProfesorComponent } from './components/profesor/add-profesor/add-profesor.component';
import { ListProfesorComponent } from './components/profesor/list-profesor/list-profesor.component';
import { ProfesorComponent } from './components/profesor/profesor/profesor.component';
import { ListAsignaturasComponent } from './components/profesor/list-asignaturas/list-asignaturas.component';
import { AsignaturaComponent } from './components/asignatura/asignatura/asignatura.component';
import { ListEstudiantesComponent } from './components/asignatura/list-estudiantes/list-estudiantes.component';

@NgModule({
  declarations: [
    AppComponent,
    AddAsignaturaComponent,
    AsignaturaComponent,
    AddProfesorComponent,
    ListProfesorComponent,
    ProfesorComponent,
    ListAsignaturasComponent,
    ListEstudiantesComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
