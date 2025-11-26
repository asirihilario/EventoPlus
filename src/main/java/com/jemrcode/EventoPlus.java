package com.jemrcode;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;
import com.jemrcode.service.EventoService;
import com.jemrcode.service.ParticipanteService;
import com.jemrcode.service.Validador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class EventoPlus {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EventoService eventoService = new EventoService();
    private static final ParticipanteService participanteService = new ParticipanteService();
    private static final Validador validador = new Validador();
    
    
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            procesarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("\nGracias por usar EventoPlus. ¡Hasta pronto!");
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA EVENTOPLUS ===");
        System.out.println("1. Registrar participante");
        System.out.println("2. Registrar evento");
        System.out.println("3. Inscribir participante en evento");
        System.out.println("4. Listar participantes");
        System.out.println("5. Listar eventos");
        System.out.println("0. Salir");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarParticipante();
            case 2 -> registrarEvento();
            case 3 -> inscribirParticipanteEnEvento();
            case 4 -> listarParticipantes();
            case 5 -> listarEventos();
            case 0 -> System.out.println("Cerrando sistema...");
            default -> System.out.println("Opción invalida. Intente nuevamente.");
        }
    }

    // --- OPCIONES DEL MENÚ ---
    private static void registrarParticipante() {
        System.out.println("\n--- REGISTRAR PARTICIPANTE ---");
        int id = leerEntero("ID: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI (8 digitos): ");
        String dni = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        if (!validador.dniValido(dni)) {
            System.out.println("DNI invalido. Debe tener 8 digitos.");
            return;
        }
        if (!validador.correoValido(correo)) {
            System.out.println("Correo invalido.");
            return;
        }

        participanteService.registrarParticipante(id, nombre, dni, correo);
        System.out.println("Participante registrado correctamente.");
    }

    private static void registrarEvento() {
        System.out.println("\n--- REGISTRAR EVENTO ---");
        int id = leerEntero("ID: ");
        System.out.print("Nombre del evento: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        int capacidad = leerEntero("Capacidad maxima: ");

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());
        System.out.print("Hora (HH:MM): ");
        LocalTime hora = LocalTime.parse(scanner.nextLine());

        eventoService.crearEvento(id, nombre, fecha, hora, descripcion, capacidad);
        System.out.println("Evento registrado correctamente.");
    }

    private static void inscribirParticipanteEnEvento() {
        System.out.println("\n--- INSCRIPCION A EVENTO ---");
        System.out.print("DNI del participante: ");
        String dni = scanner.nextLine();
        Participante participante = participanteService.buscarPorDni(dni);

        if (participante == null) {
            System.out.println("No se encontro un participante con ese DNI.");
            return;
        }

        int idEvento = leerEntero("ID del evento: ");
        Evento evento = eventoService.buscarEventoPorId(idEvento);

        if (evento == null) {
            System.out.println("No se encontró el evento.");
            return;
        }

        if (eventoService.inscribirParticipante(idEvento, participante)) {
            System.out.println("Participante inscrito exitosamente en el evento.");
        } else {
            System.out.println(" No se pudo inscribir. El evento puede estar lleno o el participante ya está inscrito.");
        }
    }

    private static void listarParticipantes() {
        System.out.println("\n=== LISTA DE PARTICIPANTES ===");
        List<Participante> lista = participanteService.listarParticipantes();
        if (lista.isEmpty()) {
            System.out.println("No hay participantes registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private static void listarEventos() {
        System.out.println("\n=== LISTA DE EVENTOS ===");
        List<Evento> lista = eventoService.listarEventos();
        if (lista.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            for (Evento e : lista) {
                System.out.println(e);
                if (e.getListaParticipantes().isEmpty()) {
                    System.out.println("  (Sin participantes inscritos)");
                } else {
                    System.out.println("  Participantes:");
                    e.getListaParticipantes().forEach(p ->
                            System.out.println("   - " + p.getNombre() + " (" + p.getDni() + ")"));
                }
            }
        }
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
}