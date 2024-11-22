package com.colegio.administrador;

import com.colegio.administrador.entity.*;
import com.colegio.administrador.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class LoadData {

    private final ColegioRepository colegioRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;
    private final ProfesorRepository profesorRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event){

        Colegio colegio=Colegio.builder().nombre("El colegio del Olimpo").build();
        Colegio colegioGuardado=colegioRepository.save(colegio);

        this.loadDatos(colegioGuardado);



    }

    private void loadDatos(Colegio colegioGuardado) {

        List<Curso> listCurso=new ArrayList<>();

        Curso curso=Curso.builder().grado(10).salon("A").colegio(colegioGuardado).build();
        Curso curso1=Curso.builder().grado(10).salon("B").colegio(colegioGuardado).build();
        Curso curso2=Curso.builder().grado(11).salon("A").colegio(colegioGuardado).build();
        Curso curso3=Curso.builder().grado(11).salon("B").colegio(colegioGuardado).build();

        Curso curso10a=cursoRepository.save(curso);
        Curso curso10b=cursoRepository.save(curso1);
        Curso curso11a=cursoRepository.save(curso2);
        Curso curso11b=cursoRepository.save(curso3);



        Profesor profesorN=Profesor.builder().nombre("Nemesis").build();
        Profesor profesorP=Profesor.builder().nombre("Priapo").build();
        Profesor profesorI=Profesor.builder().nombre("Iris").build();

        Profesor Nemsis=profesorRepository.save(profesorN);
        Profesor Priapo=profesorRepository.save(profesorP);
        Profesor Iris=profesorRepository.save(profesorI);



        Asignatura asignatura1=Asignatura.builder().nombre("Matematicas").curso(curso10a).profesor(Nemsis).build();
        Asignatura asignatura2=Asignatura.builder().nombre("Español").curso(curso10a).profesor(Priapo).build();
        Asignatura asignatura3=Asignatura.builder().nombre("Ingles Basico").curso(curso10a).profesor(Iris).build();

        Asignatura asignatura1S=asignaturaRepository.save(asignatura1);
        Asignatura asignatura2S=asignaturaRepository.save(asignatura2);
        Asignatura asignatura3S=asignaturaRepository.save(asignatura3);

        Set<Asignatura> asignaturas10a = new HashSet<>();
        asignaturas10a.add(asignatura1S);
        asignaturas10a.add(asignatura2S);
        asignaturas10a.add(asignatura3S);


        Asignatura asignatura4=Asignatura.builder().nombre("Matematicas").curso(curso10b).profesor(Nemsis).build();
        Asignatura asignatura5=Asignatura.builder().nombre("Español").curso(curso10b).profesor(Priapo).build();
        Asignatura asignatura6=Asignatura.builder().nombre("Ingles Avanzado").curso(curso10b).profesor(Iris).build();

        Asignatura asignatura4S=asignaturaRepository.save(asignatura4);
        Asignatura asignatura5S=asignaturaRepository.save(asignatura5);
        Asignatura asignatura6S=asignaturaRepository.save(asignatura6);

        Set<Asignatura> asignaturas10b = new HashSet<>();
        asignaturas10b.add(asignatura4S);
        asignaturas10b.add(asignatura5S);
        asignaturas10b.add(asignatura6S);


        Asignatura asignatura7=Asignatura.builder().nombre("Matematicas").curso(curso11a).profesor(Nemsis).build();
        Asignatura asignatura8=Asignatura.builder().nombre("Pre Icfes").curso(curso11a).profesor(Nemsis).build();

        Asignatura asignatura7S=asignaturaRepository.save(asignatura7);
        Asignatura asignatura8S=asignaturaRepository.save(asignatura8);


        Set<Asignatura> asignaturas11a = new HashSet<>();
        asignaturas11a.add(asignatura7S);
        asignaturas11a.add(asignatura8S);



        Asignatura asignatura9=Asignatura.builder().nombre("Matematicas").curso(curso11b).profesor(Nemsis).build();
        Asignatura asignatura10=Asignatura.builder().nombre("Pre Icfes").curso(curso11b).profesor(Nemsis).build();


        Asignatura asignatura9S=asignaturaRepository.save(asignatura9);
        Asignatura asignatura10S=asignaturaRepository.save(asignatura10);


        Set<Asignatura> asignaturas11b = new HashSet<>();
        asignaturas11b.add(asignatura9S);
        asignaturas11b.add(asignatura10S);


        Estudiante estudiante1=Estudiante.builder().nombre("Afrodita").asignaturas(asignaturas10a).build();
        Estudiante estudiante2=Estudiante.builder().nombre("Artemisa").asignaturas(asignaturas10b).build();
        Estudiante estudiante3=Estudiante.builder().nombre("Hefesto").asignaturas(asignaturas11a).build();
        Estudiante estudiante4=Estudiante.builder().nombre("Hermes").asignaturas(asignaturas11b).build();
        Estudiante estudiante5=Estudiante.builder().nombre("Apolo").asignaturas(asignaturas10a).build();
        Estudiante estudiante6=Estudiante.builder().nombre("Atenea").asignaturas(asignaturas10b).build();
        Estudiante estudiante7=Estudiante.builder().nombre("Hera").asignaturas(asignaturas11a).build();
        Estudiante estudiante8=Estudiante.builder().nombre("Hades").asignaturas(asignaturas11b).build();
        Estudiante estudiante9=Estudiante.builder().nombre("Ares").asignaturas(asignaturas10a).build();
        Estudiante estudiante10=Estudiante.builder().nombre("Dionisio").asignaturas(asignaturas10b).build();
        Estudiante estudiante11=Estudiante.builder().nombre("Poseidón").asignaturas(asignaturas11b).build();
        Estudiante estudiante12=Estudiante.builder().nombre("Zeus").asignaturas(asignaturas11b).build();


        estudianteRepository.save(estudiante1);
        estudianteRepository.save(estudiante2);
        estudianteRepository.save(estudiante3);
        estudianteRepository.save(estudiante4);
        estudianteRepository.save(estudiante5);
        estudianteRepository.save(estudiante6);
        estudianteRepository.save(estudiante7);
        estudianteRepository.save(estudiante8);
        estudianteRepository.save(estudiante9);
        estudianteRepository.save(estudiante10);
        estudianteRepository.save(estudiante11);
        estudianteRepository.save(estudiante12);

    }

}
