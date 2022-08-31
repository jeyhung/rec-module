package com.example.rec.migration;

import com.example.rec.constant.BranchType;
import com.example.rec.entity.*;
import com.example.rec.repository.*;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ChangeLog(order = "001")
public class InitChangeLog {
    @ChangeSet(order = "001", id = "init_branches", author = "jeyhung")
    public void initBranches(BranchRepository branchRepository) {
        List<Branch> branches = new ArrayList<>();

        branches.add(Branch.builder()
                .id("5da6d682329d8720647c9cc2")
                .parentId(null)
                .code("C")
                .name("AUTOMOBILE")
                .status(1)
                .type(BranchType.NOT_LIFE)
                .alias(Arrays.asList("auto", "automobile", "Auto", "Automobile", "Autos", "Automobiles",
                        "3- AUTOMOBILE", "Branche Automobile", "Assurance Automobile", "Transport Public de Voyageurs-4B",
                        "3.Automobile", "VEHICULE TERRESTRE A MOTEUR", "Vehicle bundle", "Véhicule terrestre à moteur",
                        "AUTOMOBILE FLOTTE", "Automobile / Motor", "AUTOMOBILE", "Véhicules terrestres à moteur",
                        "AUTO.PROMENADES-AFF M10", "AUTOMOBILE T.P.C. M20", "AUTOMOBILE T.P.V. M20", "AUTOMOBILE T.P.M. M20",
                        "AUTO. 2 & 3 ROUES M10", "ENGINS DE CHANTIERS M30", "AUTOMOBILE T.P.M. M30", "AUTOMOBILE T.P.C. M30",
                        "Assurances Automobile", "TPV", "Voitures particulières", "Legal Protection", "Third party Liability",
                        "Court-terme", "Comprehensive Protection", "Personal Accident", "Transport Public de Voyageurs-4B",
                        "ASSURANCE AUTO", "Automobile RC", "Automobile Dommages", "Assurance Autombile", "10-Automobile",
                        "VÃ©hicule terrestre Ã  moteur", "VEHICULES TERRESTRES A MOTEUR", "Vehiclebundle", "Voituresparticulières",
                        "Flotteautomobile"))
                .createdAt(LocalDateTime.parse("2019-10-16T08:36:18"))
                .updatedAt(LocalDateTime.parse("2021-05-06T02:32:22"))
                .build());

        //add other branches ...

        branchRepository.saveAll(branches);
    }

    @ChangeSet(order = "002", id = "init_cedants", author = "jeyhung")
    public void initCedants(CedantRepository cedantRepository) {
        List<Cedant> cedants = new ArrayList<>();

        cedants.add(Cedant.builder()
                .id("5dbf6153329d871d4e28f392")
                .countryId("5da8198f329d87383208ea42")
                .currencyId("5d481a52a8047a091746ec25")
                .groupCedantId("5d8213146f611f1df61cda23")
                .regionId("5d470354a8047a091746eaa3")
                .reinsuranceId("5d5e8329f873e7ccdb577890")
                .typeCedantId("5d5eb11454386910f603c9c1")
                .benefitPercentage(10)
                .code("3322")
                .color1("#323bce")
                .color2("#ebac10")
                .contact("21432435523")
                .email("nsiasur@assurance.com")
                .estimationType("prorata")
                .logo("images/cedants/logo_1574680492.jpg")
                .name("NSIA ASSURANCE")
                .createdAt(LocalDateTime.parse("2019-11-03T23:22:59"))
                .updatedAt(LocalDateTime.parse("2021-01-08T17:46:23"))
                .build());

        //add other cedants ...

        cedantRepository.saveAll(cedants);
    }

    @ChangeSet(order = "003", id = "init_countries", author = "jeyhung")
    public void initCountries(CountryRepository countryRepository) {
        List<Country> countries = new ArrayList<>();

        countries.add(Country.builder()
                .id("5d46bcbba8047a091746ea88")
                .regionId("5d470354a8047a091746eaa3")
                .code("51Y")
                .name("TOGO")
                .createdAt(LocalDateTime.parse("2019-11-03T23:22:59"))
                .updatedAt(LocalDateTime.parse("2021-01-08T17:46:23"))
                .build());

        //add other countries ...

        countryRepository.saveAll(countries);
    }

    @ChangeSet(order = "004", id = "init_group_cedants", author = "jeyhung")
    public void initGroupCedants(GroupCedantRepository groupCedantRepository) {
        List<GroupCedant> groupCedants = new ArrayList<>();

        groupCedants.add(GroupCedant.builder()
                .id("5d820fe86f611f0e73447e22")
                .name("AXA")
                .createdAt(LocalDateTime.parse("2019-09-18T11:07:20"))
                .updatedAt(LocalDateTime.parse("2019-09-19T09:43:16"))
                .build());

        //add other group cedants ...

        groupCedantRepository.saveAll(groupCedants);
    }

    @ChangeSet(order = "005", id = "init_regions", author = "jeyhung")
    public void initRegions(RegionRepository regionRepository){
        List<Region> regions = new ArrayList<>();

        regions.add(Region.builder()
                .id("5d470354a8047a091746eaa3")
                .code("02")
                .name("CIMA AFRIQUE OCCIDENTALE")
                .createdAt(LocalDateTime.parse("2019-09-18T11:07:20"))
                .updatedAt(LocalDateTime.parse("2019-11-13T10:56:24"))
                .build());

        //add other regions ...

        regionRepository.saveAll(regions);
    }
}
