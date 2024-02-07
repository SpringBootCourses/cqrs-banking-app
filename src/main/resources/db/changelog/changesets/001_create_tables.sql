create table accounts
(
    id      varchar(36) primary key,
    number  varchar not null unique,
    balance numeric not null default 0
);

create table clients
(
    id         varchar(36) primary key,
    name       varchar     not null,
    account_id varchar(36) not null,
    constraint clients_accounts foreign key (account_id) references accounts (id)
);

create table cards
(
    id         varchar(36) primary key,
    number     varchar(16) not null,
    date       varchar(5)  not null,
    cvv        varchar(3)  not null,
    account_id varchar(36) not null,
    constraint cards_unique unique (number, date),
    constraint cards_accounts foreign key (account_id) references accounts (id)
);

create table client_cards
(
    client_id varchar(36) not null,
    card_id   varchar(36) not null,
    constraint client_cards_unique unique (client_id, card_id),
    constraint client_cards_clients foreign key (client_id) references clients (id),
    constraint client_cards_cards foreign key (card_id) references cards (id)
);

create table transactions
(
    id      varchar(36) primary key,
    from_id varchar(36) not null,
    to_id   varchar(36) not null,
    constraint transactions_cards_from foreign key (from_id) references cards (id),
    constraint transactions_cards_to foreign key (to_id) references cards (id)
);