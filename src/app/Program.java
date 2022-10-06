package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = scan.nextInt();
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Digite os dados do %do contribuinte:%n", i + 1 );
			System.out.print("Renda anual com salário: ");
			double salaryIncome = scan.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = scan.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = scan.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = scan.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationalSpending = scan.nextDouble();
			System.out.println();
			
			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationalSpending);
			
			list.add(taxPayer);
			
		}
		
		for(TaxPayer x : list) {
			System.out.println(x);
		}
		
		scan.close();
	}

}
