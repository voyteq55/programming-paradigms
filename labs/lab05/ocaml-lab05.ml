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

type lotteryTicketMod = TicketMod of lotteryTicketMod Lazy.t | RewardMod of string

let rec buyTicketMod tableWithTickets ticketNumber =
  match tableWithTickets with
  | [] -> []
  | ticketsHead :: ticketsTail ->
    if ticketNumber <> 1 then ticketsHead :: buyTicketMod ticketsTail (ticketNumber - 1) else
      match ticketsHead with
      | RewardMod(rewardName) -> RewardMod(rewardName) :: ticketsTail
      | TicketMod(ticketToReveal) -> Lazy.force ticketToReveal :: ticketsTail

let ticketsMod = [
  TicketMod(lazy (RewardMod("reward1")));
  TicketMod(lazy (RewardMod("reward2")));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward3")))));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward4")))));
  TicketMod(lazy (RewardMod("reward5")))
]

let ticketsMod2 = [
  TicketMod(lazy (RewardMod("reward1")));
  TicketMod(lazy (RewardMod("reward2")));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward3")))));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward4")))));
  TicketMod(lazy (RewardMod("reward5")))
]

let ticketsMod3 = [
  TicketMod(lazy (RewardMod("reward1")));
  TicketMod(lazy (RewardMod("reward2")));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward3")))));
  TicketMod(lazy (TicketMod(lazy (RewardMod("reward4")))));
  TicketMod(lazy (RewardMod("reward5")))
]

let buyTicketModTest1 = buyTicketMod ticketsMod 2
let buyTicketModTest2 = buyTicketMod buyTicketModTest1 2

let buyTicketModTest3 = buyTicketMod ticketsMod2 3
let buyTicketModTest4 = buyTicketMod buyTicketModTest3 3

let buyTicketModTest5 = buyTicketMod ticketsMod3 0
let buyTicketModTest6 = buyTicketMod ticketsMod3 50
