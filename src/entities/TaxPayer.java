package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
	}
	
	public TaxPayer( Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	//Gets Sets
	
	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}
	
	//Methods
	
	public double salaryTax(double salaryIncome) {
		if(salaryIncome / 12 < 3000.0) {
			return 0.0;
		}
		else if(salaryIncome / 12  < 5000.0 ) {
			return salaryIncome * 0.1;
		}
		else {
			return salaryIncome * 0.2;
		}
	}
	
	public double serviceTax(double servicesIncome) {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax(double capitalIncome) {
		return capitalIncome * 0.2;
	}
	
	public double grossTax(double salaryIncome, double servicesIncome, double capitalIncome) {
		return salaryTax(salaryIncome) + serviceTax(servicesIncome) + capitalTax(capitalIncome);
	}

	public double taxRebate(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
		if(grossTax(salaryIncome, servicesIncome, capitalIncome) * 0.3 > healthSpending + educationSpending) {
			return healthSpending + educationSpending;
		}
		else {
			return grossTax(salaryIncome, servicesIncome, capitalIncome) * 0.3;
		}
	}
	
	public double netTax(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
		return grossTax(salaryIncome, servicesIncome, capitalIncome) - taxRebate(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
	}
	
	public String toString() {
		
		return String.format("Imposto bruto total: %.2f%n", grossTax(salaryIncome, servicesIncome, capitalIncome))
				+ String.format("Abatimento: %.2f%n", taxRebate(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending))
				+ String.format("Imposto devido: %.2f%n", netTax(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
	}
}
