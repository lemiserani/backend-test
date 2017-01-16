class ApplicationSettings

              def setup!
                    setup_defaults!
              end

              private

              def setup_defaults!
                      $env = ENV['ENV']
                      $debug = ENV['debug'] || 'false'
                      $opportunity_server = {
                        'local' => "http://localhost:8080"                                              
                      }
                      $opportunity_headers = {
                                            "Content-Type" => "application/json",
                                            "Accept" => "application/json"
                      }
                      $opportunity_authentication = {
                          'local' => {:username => "admin", :password => "admin"}
                      }

              end

end
