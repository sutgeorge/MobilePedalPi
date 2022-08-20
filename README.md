# MobilePedalPi
A Kotlin/Android Raspberry Pi-based app serving as a convenient replacement for a commercial guitar pedal. 

## Chronological to-do list
- [X] Create to-do list
- [X] Establish in Google Calendar a timeframe for working on the project
- [ ] Read about Puredata
- [ ] Read about Puredata guitar effects
- [ ] Watch Puredata tutorials
- [ ] Create a Puredata effect
- [ ] Test whether the Puredata effect works with the guitar (Big Jack/small Jack adapter for the guitar cable plugged into the laptop)
- [ ] Read about how Puredata could be used on Raspberry Pi and test it
- [ ] Read about Hifiberry DAC+ADC soundcard
- [ ] Read about Kotlin Jetpack Compose
- [ ] Read about other Raspberry Pi guitar pedal projects with Hifiberry
- [ ] Read about Bluetooth modules for Raspberry Pi
- [ ] Read about Kotlin Android Bluetooth connectivity
- [ ] Watch some Kotlin Android tutorials
- [ ] Create UML diagrams for the app structure
- [ ] Re-read/refresh knowledge on design patterns
- [ ] Think of design patterns that could be used
- [ ] Read about UI/UX for mobile apps
- [ ] Design the circuit diagram (Raspberry Pi board + Hifiberry DAC+ADC soundcard + RCA / Jack adapters)
- [ ] Buy components
- [ ] Assemble the components
- [ ] Implement a quick initial version
- [ ] Design UI/UX
- [ ] Finish a full initial version of the app
- [ ] Test it
- [ ] Create a demo video
- [ ] Update README.md

## Resources

### Project management
- [How to create a PERT chart](https://asana.com/resources/pert-chart)
- [9 Best Open-Source Gantt Chart Software For Linux](https://itsfoss.com/open-source-gantt-chart/) 

### Puredata
- [Puredata Tutorial](https://puredata.info/docs/StartHere/)
- [Puredata error: "priority 6 scheduling failed; running at normal priority"](https://www.reddit.com/r/puredata/comments/88uwyo/installing_pd_for_linux_mint_18/)
> Solution:
>	1. Update Kernel    
>	2. Create audio group: sudo groupadd audio
>	3. Add your user to audio group: sudo gpasswd -a <username> audio
>	4. Create group limits file for audio group: sudo nano /etc/security/limits.d/audio.conf
>	5. Add the following lines to audio.conf:
>  
> 		@audio   -  rtprio     95
>		@audio   -  memlock    unlimited
>		#@audio   -  nice       -19
> 
>	6. Reboot

