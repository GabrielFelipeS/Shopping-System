package com.br.onlineshoppingsystem.model.services.paymentMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.br.onlineshoppingsystem.model.exceptions.DomainException;

public class Payment  {
	private Scanner sc = new Scanner(System.in);
	
	public void creditCard(Double orderTotalCost) {

        // Pattern to format Due date of credit card (month(2 digits) / year (4 digits))
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");

        System.out.println("\n--- Credit cart ---");
        long cardNumber;
        int cvv;
        Date dueDate;

        System.out.println("\nValue to pay: " + String.format("%.2f", orderTotalCost));

        while (true) {

            System.out.print("Card number or [m] to go back to menu: ");
            String cardNumberInput = sc.next();

            System.out.print("Write CVV: ");
            String cvvInput = sc.next();

            System.out.print("Due date: ");
            String dueDateInput = sc.next();

            try {

                if (cardNumberInput.equals("m")) return;

                if (cardNumberInput.length() > 16 || cardNumberInput.length() < 14){
                	throw new DomainException("\nPlease a right Card number valid!");
                }
                // cvv only accept 3 digits (Brazil card)
                else if (cvvInput.length() != 3 || cvvInput.equals("000")){
                    throw new DomainException("\nPlease a right CVV value!");
                }

                // cardNumber only accept 14, 15 or 16 digits (Brazil card)

                if (dueDateInput.equals("00/0000")){
                    throw new DomainException("\nPlease a right Due date value!");
                }

                cardNumber = Long.parseLong(cardNumberInput);
                cvv = Integer.parseInt(cvvInput);
                dueDate = df.parse(dueDateInput);

                // Due date credit card should not be before the instant now
                if (dueDate.before(Date.from(Instant.now()))){
                    throw new DomainException("\nPlease a right Due date value!");
                }

                System.out.println("\nPayment successfully!");
                break;

            } catch (NumberFormatException e) {
                System.out.println("\nPlease a valid value!");
            } catch (DomainException e) {
                System.out.println(e.getMessage());
            } catch (ParseException e) {
                System.out.println("\nPlease a right Due date value!");
            }
        }
    }

   public void bankTransfer(Double orderTotalCost) {
        while (true) {
            System.out.println("\n--- Bank Transfer ---");

            // Agency
            System.out.print("\nAgency: ");
            String agencyInput = sc.nextLine();
            
            long agency;

            try {
                agency = Long.parseLong(agencyInput);
                System.out.println("Value to pay: " + String.format("%.2f", orderTotalCost));
                System.out.print("Payment made ([y] yes), ([n] no) or ([m] to go to menu)? ");
                char paymentMade = sc.nextLine().charAt(0);

                if (paymentMade == 'm') return;

                if (paymentMade == 'y'){
                    System.out.println("\nPayment successfully!");
                    break;
                }
                else System.out.println("\nPlease make payment!");

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("\nPlease a valid information!");
            }
        }
    }
    public void pix(Double orderTotalCost){
        // Pix is the system the Brazilian Central Bank created to bring instant payments to life
        System.out.println("\n--- PIX ---");

        // PIX key to get the payment done
        System.out.println("PIX key: 123456678");

        while (true ){
            try {
            	
                System.out.println("Value to pay: " + String.format("%.2f", orderTotalCost));
                System.out.print("Payment made ([y] yes), ([n] no) or ([m] to go to menu)? ");
                char paymentMade = sc.next().charAt(0);

                if (paymentMade == 'm') return;

                if (paymentMade == 'y') {
                    System.out.println("\nPayment successfully!");
                    break;
                } else System.out.println("\nPlease make payment!");

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("\nPlease a valid information!");
            }
        }
    }
    
    public void bitcoin(Double orderTotalCost){
        System.out.println("\n--- BITCOIN ---\n");

        // 03/10/2023 in Reais (Brazil currency)
        int bitCoinValue = 142099;
        double valueToPayInBitcoins = orderTotalCost / bitCoinValue;

        while (true){
            try {
                System.out.println("Bitcoin value: " + bitCoinValue);
                System.out.println("Value to pay: " + String.format("%.2f", orderTotalCost));
                System.out.println("Bitcoins to pay: " + String.format("%.5f", valueToPayInBitcoins));
                System.out.print("Your wallet: ");
                Long wallet = sc.nextLong();

                System.out.print("Payment made ([y] yes), ([n] no) or ([m] to go to menu)? ");
                char paymentMade = sc.next().charAt(0);

                if (paymentMade == 'm') return;

                if (paymentMade == 'y') {
                    System.out.println("\nPayment successfully!");
                    break;
                } else System.out.println("\nPlease make payment!");

            } catch (InputMismatchException e) {
                System.out.println("\nPlease a valid information!");
                sc.nextLine();
            }
        }
    }
}
