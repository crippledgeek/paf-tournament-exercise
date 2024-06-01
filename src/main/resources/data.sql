-- Insert test data into player table
INSERT INTO public.player (id, name) VALUES
                                         (1, 'Player 1'),
                                         (2, 'Player 2'),
                                         (3, 'Player 3');

-- Insert test data into tournament table
INSERT INTO public.tournament (id, name, reward_amount) VALUES
                                                            (1, 'Tournament 1', 1000.00),
                                                            (2, 'Tournament 2', 2000.00),
                                                            (3, 'Tournament 3', 3000.00);

-- Insert test data into player_tournaments table
INSERT INTO public.player_tournaments (player_id, tournaments_id) VALUES
                                                                      (1, 1),
                                                                      (1, 2),
                                                                      (2, 2),
                                                                      (3, 1),
                                                                      (3, 3);