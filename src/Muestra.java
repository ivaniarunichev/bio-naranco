public class Muestra {
    private String idMuestra;
    private String idPaciente;
    private String idTecnico;
    private String tipo;
    private String estado;
    private int vol_ml;

    //Constructor
    public Muestra(String idMuestra, String idPaciente, String idTecnico, String tipo, String estado, int vol_ml) {
        this.idMuestra = idMuestra;
        this.idPaciente = idPaciente;
        this.idTecnico = idTecnico;
        this.tipo = tipo;
        this.estado = estado;
        this.vol_ml = vol_ml;
    }

    //Getters y Setters
    public String getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVol_ml() {
        return vol_ml;
    }

    public void setVol_ml(int vol_ml) {
        this.vol_ml = vol_ml;
    }
}
