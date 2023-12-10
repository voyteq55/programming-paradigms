type lotteryTicket = Ticket of (unit -> lotteryTicket) | Reward of string

let rec buyTicket tableWithTickets ticketNumber =
  match tableWithTickets with
  | [] -> []
  | ticketsHead :: ticketsTail ->
    if ticketNumber <> 1 then ticketsHead :: buyTicket ticketsTail (ticketNumber - 1) else
      match ticketsHead with
      | Reward(rewardName) -> Reward(rewardName) :: ticketsTail
      | Ticket(ticketToReveal) -> ticketToReveal () :: ticketsTail

let tickets = [
  Ticket(fun () -> Reward("r1"));
  Ticket(fun () -> Reward("r2"));
  Ticket(fun () -> Ticket(fun () -> Reward("r3")));
  Ticket(fun () -> Ticket(fun () -> Reward("r4")));
  Ticket(fun () -> Reward("r5"))
]

let buyTicketTest1 = buyTicket tickets 2
let buyTicketTest2 = buyTicket buyTicketTest1 2

let buyTicketTest3 = buyTicket tickets 3
let buyTicketTest4 = buyTicket buyTicketTest3 3

let buyTicketTest5 = buyTicket tickets 0
let buyTicketTest5 = buyTicket tickets 50
