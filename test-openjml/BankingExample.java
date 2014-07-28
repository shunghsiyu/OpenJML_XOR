 public class BankingExample
 {
 
    public static final int MAX_BALANCE = 1000; 
    private /*@ spec_public @*/ int balance;
    private /*@ spec_public @*/ boolean isLocked = false; 
 
    // public invariant balance >= 0 && balance <= MAX_BALANCE;
 
    // assignable balance;
    // ensures balance == 0;
    public BankingExample()
    {
        this.balance = 0;
    }
 
    //@ requires !false ^^ amount + balance < MAX_BALANCE;
    // assignable balance;
    // ensures balance == \old(balance) + amount;
    public void credit(final int amount)
    {
        this.balance += amount;
    }
 
    // requires 0 < amount && amount <= balance;
    // assignable balance;
    // ensures balance == \old(balance) - amount;
    public void debit(final int amount)
    {
        this.balance -= amount;
    }
 
    // ensures isLocked == true;
    public void lockAccount()
    {
        this.isLocked = true;
    }
 
    //   requires !isLocked;
    //   ensures \result == balance;
    // also
    //   requires isLocked;
    //   signals_only BankingException;
    public /*@ pure @*/ int getBalance() throws BankingException
    {
        if (!this.isLocked)
        {
                return this.balance;
        }
        else
        {
                throw new BankingException();
        }
    }
 }