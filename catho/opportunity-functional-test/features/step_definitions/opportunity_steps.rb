When(/^Opportunity API execute Get in ElasticSearch with q=Joinville & fields=cidade & page=0 & limit=10 & orderby=salario & sorted=asc$/) do
  $job_array = Array.new
  $job_array = OpportunityService.new("/job/search?q=Joinville&fields=cidade&page=0&limit=10&orderby=salario&sorted=asc").get["docs"]
end

Then(/^Opportunity verify fields of each Job$/) do
  field_array =  {"title" => "title",
                  "description" => "description",
                  "salario" => "salario",
                  "cidade" => ["cidade"],
                  "cidadeFormated" => ["cidadeFormated"]
                 }
  size = $job_array.size              
  Debug.new.debug_msg("size................. #{size}\n")   
  size.should ==  10
  $job_array.each do |job|
      Debug.new.debug_msg("job................. #{job}\n")   
      job["cidade"].first.should == "Joinville"         
  end
end

When(/^Opportunity API execute Get in ElasticSearch with q=Joinville & fields=cidade & page=1000 & limit=10 & orderby=salario & sorted=asc$/) do
  $job_array = Array.new
  $job_array = OpportunityService.new("/job/search?q=Joinville&fields=cidade&page=1000&limit=10&orderby=salario&sorted=asc").get["docs"]
end

Then(/^Opportunity verify result without Job$/) do
  size = $job_array.size              
  Debug.new.debug_msg("size................. #{size}\n")   
  size.should ==  0
end

When(/^Opportunity API execute Get in ElasticSearch with q=2000 & fields=salario & page=0 & limit=10 & orderby=salario & sorted=asc$/) do
  $job_array = Array.new
  $job_array = OpportunityService.new("/job/search?q=2000&fields=salario&page=0&limit=10&orderby=salario&sorted=asc").get["docs"]
end

Then(/^Opportunity verify field salary with value 2000$/) do
  field_array =  {"title" => "title",
                  "description" => "description",
                  "salario" => "salario",
                  "cidade" => ["cidade"],
                  "cidadeFormated" => ["cidadeFormated"]
                 }
  size = $job_array.size              
  Debug.new.debug_msg("size................. #{size}\n")   
  size.should ==  10
  $job_array.each do |job|
      Debug.new.debug_msg("job................. #{job}\n")   
      job["salario"].should == "2000"        
  end
end

When(/^Opportunity API execute Get in ElasticSearch with q=100000 & fields=salario & page=0 & limit=10 & orderby=salario & sorted=asc$/) do
  $job_array = Array.new
  $job_array = OpportunityService.new("/job/search?q=100000&fields=salario&page=0&limit=10&orderby=salario&sorted=asc").get["docs"]
end

Then(/^Opportunity verify field salary with value 100000$/) do
  size = $job_array.size              
  Debug.new.debug_msg("size................. #{size}\n")   
  size.should ==  0
end

When(/^Opportunity API execute Get in ElasticSearch with q=Auxiliar & fields=title & page=0 & limit=100 & orderby=salario & sorted=asc$/) do
  $job_array = Array.new
  $job_array = OpportunityService.new("/job/search?q=Auxiliar&fields=title&page=0&limit=100&orderby=salario&sorted=asc").get["docs"]
end

Then(/^Opportunity verify field limit with value 100$/) do
  size = $job_array.size              
  Debug.new.debug_msg("size................. #{size}\n")   
  size.should ==  100
end

When(/^Opportunity API execute Get in ElasticSearch with q=Auxiliar & fields=title & page=0 & limit=10 & orderby=salario & sorted=asc$/) do
  $total = OpportunityService.new("/job/search?q=Auxiliar&fields=title&page=0&limit=100&orderby=salario&sorted=asc").get["hits"]
end

Then(/^Opportunity verify field hits$/) do
  Debug.new.debug_msg("size................. #{$total}\n")   
  $total.should == 225
end
