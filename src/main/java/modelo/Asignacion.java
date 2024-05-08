package modelo;

public class Asignacion {
    private int tareaId;
    private int usuarioId;

    public Asignacion() {
        // Constructor vacío
    }

    public Asignacion(int tareaId, int usuarioId) {
        this.tareaId = tareaId;
        this.usuarioId = usuarioId;
    }

    public int getTareaId() {
        return tareaId;
    }

    public void setTareaId(int tareaId) {
        this.tareaId = tareaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Asignacion{" +
                "tareaId=" + tareaId +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
