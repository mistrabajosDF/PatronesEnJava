package P2_E6;

/*
 * Sea una aplicación que ofrece excursiones. Una excursión posee nombre, fecha de inicio, fecha de fin, punto de encuentro, costo, cupo mínimo y cupo máximo.
La aplicación ofrece las excursiones pero éstas sólo se realizan si alcanzan el cupo mínimo de inscriptos. Un usuario se inscribe a una excursión y si aún no se alcanzó el cupo
mínimo, la inscripción se considera provisoria. Luego, cuando se alcanza el cupo mínimo, la inscripción se considera definitiva y podrá llevarse a cabo. Finalmente, cuando se alcanza el
cupo máximo, la excursión solo registrará nuevos inscriptos en su lista de espera.
De los usuarios inscriptos, la aplicación registra su nombre, apellido y email.

Por otro lado, en todo momento la excursión ofrece información de la misma, la cual consiste en una serie de datos que varían en función de la situación.
- Si la excursión no alcanza el cupo mínimo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, cantidad de usuarios faltantes para alcanzar el
cupo mínimo.
- Si la excursión alcanzó el cupo mínimo pero aún no el máximo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, los mails de los usuarios
inscriptos y cantidad de usuarios faltantes para alcanzar el cupo máximo.
- Si la excursión alcanzó el cupo máximo, la información solamente incluye nombre, costo, fechas y punto de encuentro.

 Implementar lo necesario para instanciar una excursión, para instanciar un usuario y los mensajes:
(i) public void inscribir (Usuario unUsuario)
(ii) public String obtenerInformacion().
Test para inscribir a un usuario en la excursión “Dos días en kayak bajando el Paraná”, con cupo mínimo de 1 persona y cupo máximo 2, con dos personas ya
inscriptas. Implemente todos los mensajes que considere necesarios.

 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puntoEncuentro;
    private double costo;
    private int cupoMinimo;
    private int cupoMaximo;
    private List<Usuario> inscriptos = new ArrayList<>();
    private List<Usuario> enEspera = new ArrayList<>();
    private EstadoExcursion estado;

    public Excursion(String nombre, LocalDate inicio, LocalDate fin, String punto, double costo, int min, int max) {
        this.nombre = nombre;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.puntoEncuentro = punto;
        this.costo = costo;
        this.cupoMinimo = min;
        this.cupoMaximo = max;
        this.estado = new EstadoProvisoria();
    }

    public void inscribir(Usuario usuario) {
        estado.inscribir(usuario, this);
        actualizarEstado();
    }

    public String obtenerInformacion() {
        return estado.obtenerInformacion(this);
    }

    public void agregarInscriptos(Usuario usuario) {
        inscriptos.add(usuario);
    }

    public void agregarEspera(Usuario usuario) {
        enEspera.add(usuario);
    }

    public List<Usuario> getInscriptos() {
        return inscriptos;
    }

    public List<Usuario> getEnEspera() {
        return enEspera;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public double getCosto() {
        return costo;
    }

    public void setEstado(EstadoExcursion estado) {
        this.estado = estado;
    }

    private void actualizarEstado() {
        if (inscriptos.size() >= cupoMaximo) {
            setEstado(new EstadoCompleta());
        } 
		else 
			if (inscriptos.size() >= cupoMinimo) {
            setEstado(new EstadoDefinitiva());
        }
    }
}
