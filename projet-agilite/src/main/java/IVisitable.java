
public interface IVisitable {
	double accept(IVisiteur visitor);
}

interface IVisiteur {
    double visit(IVisitable o);
    double visit(AppartementPersonnel o,double prixM2);
    double visit(Personne o);
    double visit(CompteBancaire o);

}

